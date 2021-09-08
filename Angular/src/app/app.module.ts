import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AlertModule } from './_alert';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { NgSelectModule } from '@ng-select/ng-select'; 
import { SelectService } from './select.service';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { NgxPaginationModule } from 'ngx-pagination';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { CommonModule } from '@angular/common';
import { ConfirmationDialogComponent } from './confirmation-dialog/confirmation-dialog.component';
import { ConfirmationDialogService } from './confirmation-dialog.service';

const materialModules = [
  MatTableModule,
  MatPaginatorModule,
  MatSortModule
];

@NgModule({
  declarations: [
    AppComponent,
    AddTutorialComponent,
    TutorialDetailsComponent,
    TutorialsListComponent,
    AddStudentComponent,
    StudentListComponent,
    UpdateStudentComponent,
    ConfirmationDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgSelectModule,
    FormsModule,
    AlertModule,
    HttpClientModule,
    CommonModule,
    ...materialModules,
  
    ReactiveFormsModule,
    NgMultiSelectDropDownModule,
    NgxPaginationModule,
    HttpClientModule,
    NgMultiSelectDropDownModule.forRoot(),
    NoopAnimationsModule     
  ],
  providers: [SelectService,
      StudentListComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
