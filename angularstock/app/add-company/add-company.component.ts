import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {
  success: string;
  failure: string;
  constructor(private crudOperations: UserService) { }

  ngOnInit() {
  }

  addCompany(form: NgForm) {
    console.log(form);
    this.crudOperations.addCompanyData(form.value).subscribe(data => {
      
      if (data.statusCode === 201) {
        console.log(data);
        console.log(form.value);
        this.success = data.description;
        
      } else {
        console.log(data);
        this.failure = data.description;
      }
        setTimeout(() => {
          this.success = null;
        }, 2000);
        form.reset();
      }
    );

}

}
