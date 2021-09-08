import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TutorialService } from '../services/tutorial.service';
import { Student } from '../student';
import { AlertService } from '../_alert';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  currentStudent:Student={
    id:'',
    fullName:'',
    userName:'',
    email:'',
    phoneNumber:'',
    password:'',
    courses:{},

}
categories :any = [];
selected : any = [];
message = '';
 res:any;
 dropdownSettings = {};
constructor(private tutorialService: TutorialService,
  private route: ActivatedRoute,
  private alertService: AlertService,
  private router: Router) { }

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
     this.getStudent(this.route.snapshot.params.id);
}

getStudent(id: number): void {
  
  this.tutorialService.getById(id).subscribe(
      data => {
        this.currentStudent = data;
        this.selected = data.courses;
       // this.res = this.datepipe.transform(data.dob, 'yyyy-MM-dd');
 
      },
      error => {
        console.log(error);
      });
}

updateStudent(): void {
  this.message = '';

  this.tutorialService.update(this.currentStudent.id, this.currentStudent)
    .subscribe(
      response => {
        this.router.navigate(['/student-list']);
        console.log(response);
        this.alertService.info('Student updated successfully !!');
      },
      error => {
        console.log(error);
      });
}

deleteStudent(): void {
  this.tutorialService.delete(this.currentStudent.id)
    .subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/student-list']);
        this.alertService.warn('Student deleted successfully !!');
      },
      error => {
        console.log(error);
      });
}

onItemSelect(item: any) {
  this.selected.push(item);
}
onSelectAll(items: any) {
  this.selected.push(items);
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
