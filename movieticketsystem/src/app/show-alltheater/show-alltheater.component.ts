import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-show-alltheater',
  templateUrl: './show-alltheater.component.html',
  styleUrls: ['./show-alltheater.component.css']
})
export class ShowAlltheaterComponent implements OnInit {
  theaters;
  constructor(private http:HttpClient,private authService: AuthenticationService,
              private router: Router) {
                this.searchTheater();
  }
  ngOnInit() {
  }
  searchTheater(){
    console.log(this.authService.theaterCity);
    this.authService.getTheater(this.authService.theaterCity).subscribe(response=>{
     console.log(response);
     this.theaters = response.theater;  
    }
    );
  }

  showMovie(){
this.authService.getTheater(this.authService.theaterCity).subscribe(response=>{
  this.theaterName = response.theater.theaterName;
  console.log(response.theater.theaterName);
 
 }
 );


    if(this.authService.theaterName=='Iylex'){
 this.router.navigateByUrl("/iylex");
  }else{
this.router.navigateByUrl("/inox")
  }
}
  theaterName(theaterName: any) {
    throw new Error("Method not implemented.");
  }

}
