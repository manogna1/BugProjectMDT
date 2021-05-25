import { Component, OnInit } from '@angular/core';
import Bug from '../Bug';
import BugService from '../services/BugService';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-bugform',
  templateUrl: './bugform.component.html',
  styleUrls: ['./bugform.component.css']
})
export class BugformComponent implements OnInit {
  bugForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private bugService: BugService) { }

  ngOnInit() {
    this.bugForm = this.formBuilder.group({
      owner: ['', Validators.required],
      ownerProject: ['', Validators.required],
      priority: ['', Validators.required],
      emailAddress: ['', [Validators.required, Validators.email]],
      status: ['', [Validators.required]],
      createdDate: ['', Validators.required],
      attachedFiles: [''],
      completionDate: [''],
      description: [''],

    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.bugForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.bugForm.invalid) {
      console.log('Invalid Form!! Try submitting Valid Bug!!');
      return;
    }

    console.log(this.bugForm.value);
    this.bugService.sendSaveRequest(this.bugForm.value).subscribe(res => {
      console.log(res);
    });
  }

  onReset() {
    this.submitted = false;
    this.bugForm.reset();
  }
}

