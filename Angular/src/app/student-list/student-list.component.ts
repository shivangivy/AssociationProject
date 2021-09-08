import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TutorialService } from '../services/tutorial.service';
import { Student } from '../student';
import { PaginationService } from '../pagination.service'
import { MatTableDataSource } from '@angular/material/table';
import { ConfirmationDialogService } from '../confirmation-dialog.service';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  listOfData:any;

  @Input() title?: string;
  @Input() message?: string;
  @Input() btnOkText?: string;
  @Input() btnCancelText?: string;
  dataSource = new MatTableDataSource<any>();

  Articles: any;
  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  students?: Student[];
  currentStudent?: Student;
  currentIndex = -1;
  id = '';
  fullName='';
  options = {
    autoClose: false,
    keepAfterRouteChange: false
};
  alertService: any;


  constructor(private tutorialService: TutorialService,
    private route: ActivatedRoute,
    private paginationService: PaginationService,
    private confirmationDialogService: ConfirmationDialogService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.showData();
    this.retrieveStudents();
  }

  getRequestParams(searchName: string,page: number, pageSize: number): any {
    // tslint:disable-next-line:prefer-const
    let params: any = {};

    if (searchName) {
      params[`name`] = searchName;
    }

      if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }


  retrieveStudents(): void {
    const params = this.getRequestParams( this.fullName,this.page, this.pageSize);
    this.tutorialService.getAllStudents(params)
      .subscribe(
        data => {
          this.students = data;
          this.listOfData = data.students;
          this.count = data.totalItems;
          console.log(data);
        
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    
    this.retrieveStudents();
 
    this.currentStudent = undefined;
    this.currentIndex = -1;
  }
  deleteStudent(id:any): void {
    this.tutorialService.delete(id).subscribe(
        response => {
          this.retrieveStudents();
          this.router.navigate(['/student-list']);
          this.alertService.warn('Student deleted successfully !!');
         },
        error => {
          console.log(error);
        });
  }

  openConfirmationDialog(id:any) {
    this.confirmationDialogService.confirm('Please confirm..', 'Do you really want to delete... ?')
    .then((confirmed) => this.deleteStudent(id))
    .catch(() => console.log('User dismissed the dialog (e.g., by using ESC, clicking the cross icon, or clicking outside the dialog)'));
  }

  showData(): void {
    this.paginationService.fetchPosts()
      .subscribe(
        res => {
          this.Articles = res;
          console.log(res);
        },
        err => {
          console.log(err);
        });
  }

  tabSize(event: any){
    this.page = event;
    this.showData();
  }  

  tableData(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.showData();
  }  

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveStudents();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveStudents();
  }

  searchName():void{
    this.page=1;
    this.retrieveStudents();
  }
}
