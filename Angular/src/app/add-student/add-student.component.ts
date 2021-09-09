import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TutorialService } from '../services/tutorial.service';
import { Student } from '../student';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { AlertService } from '../_alert';
import { ConfirmedValidator } from '../validation';
import { Course } from '../course';
import { Country } from '../country';
import { State } from '../state';
import { SelectService } from '../select.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  
  // selectedCountry: Country = new Country(2, 'Brazil');
  // countries?: Country[];
  // states?: State[];

  categories :any = [];

  selected:any = [];
  static regId:number;
  alert: boolean = false;
  register: Student = {
    id: '',
    fullName: '',
    userName: '',
    email: '',
    phoneNumber: '',
    password: '',
    dob: '',
    //courses:{}
    };

    course: Course={
      id:'',
      name:'',
      duration:''
    }
  duplicate = false;
  coursesList: any;
  form!: FormGroup;
  submitted = false;
  options = {
    autoClose: false,
    keepAfterRouteChange: false
  };
  dropdownSettings = {};
  constructor(private formBuilder: FormBuilder, private tutorialService: TutorialService,
    private route: ActivatedRoute,
    private router: Router,
    public alertService: AlertService,
    private selectService: SelectService,
    private _formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'courseId',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'Unselect All',
      itemsShowLimit: 3
   }
    this.getAllCourses();

    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });

    // this.countries = this.selectService.getCountries();
    // this.onSelect(this.selectedCountry.id);

    this.form = this.formBuilder.group(
      {
        id: '',
        fullName: ['', Validators.required],
        userName: [
          '',
          [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(20),
          ]
        ],
        email: ['', [Validators.required, Validators.email]],

        phoneNumber: ['', [Validators.required]],

        dob: ['', [Validators.required]],

        name: ['', [Validators.required]],

        duration: ['', [Validators.required]],

        course: [{}, [Validators.required]],

        password: [
          '',
          [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(40)
          ]
        ],
        confirmPassword: ['', Validators.required],
        acceptTerms: [false, Validators.requiredTrue]
      },

      {
        validator: ConfirmedValidator('password', 'confirmPassword')
      }

    );
  }

  onSelect(countryid: any) {
    console.log(this.selected)
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  changeFn(item: any) {
    this.selected.push(item);
  }
  onItemSelect(item: any) {
    this.selected.push(item);
  }
  onSelectAll(items: any) {
    this.selected.push(items);
  }

  getSelectedValue(){
    console.log(this.selected);
  }

  onSubmit(data: any): void {
    data.courses = this.selected;
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    console.log("Saved data is:" + data);
    
    this.tutorialService.saveStudent(data).subscribe(
      response => {
        this.router.navigate(['/student-list']);
        this.submitted = true;
        this.alertService.success('Registered successfully');
        
      },

      error => {
        console.log(error);
      });

    //   console.log("Saved data is:" + data);
    // this.tutorialService.saveStudent(data).subscribe(
    //   response => {


    //     this.router.navigate(['/student-list']);
    //     this.submitted = true;
    //    },

    //   error => {
    //     console.log(error);
    //   });


  }

  addCourse(data: any){

    this.tutorialService.saveCourse(this.register.id, this.course)
    .subscribe(
      response => {
        this.router.navigate(['/student-list']);
        console.log(response);
        this.alertService.info('Course updated successfully !!');
      },
      error => {
        console.log(error);
      });

  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }

  onBlurEvent(userName: any) {
    this.tutorialService.checkDuplicates(userName)
      .subscribe(
        data => {
          if (data.length > 0)
            this.duplicate = true;
        },
        error => {
          console.log(error);
        });
  }


  getAllCourses(): void {
  
    this.tutorialService.getAllCourses()
      .subscribe(
        data => {
          this.categories = data;
          console.log(data);
        
        },
        error => {
          console.log(error);
        });
  }


}
