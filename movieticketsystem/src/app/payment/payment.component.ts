import { Component, OnInit } from '@angular/core';
import * as Inputmask from "inputmask";
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor() { }
  
  public yearMask = [ /[2-9]/, /\d/, /\d/,/\d/]
  public cvMask = [ /\d/, /\d/,/\d/]
  public cardMask = [ /[1-9]/, /\d/, /\d/,/\d/, ' ', /\d/, /\d/, /\d/,/\d/, ' ', /\d/, /\d/, /\d/, /\d/,' ', /\d/, /\d/, /\d/, /\d/]
  monthMask = function(rawValue) {
    // add logic to generate your mask array  
    if (rawValue && rawValue.length > 0) {
        if (rawValue[0] == '0') {
            return [/[01]/, /[1-9]/];
        } else {
            return [/[01]/, /[0-2]/];
        }
    }
    return [/[01]/, /[0-9]/];
}
  ngOnInit() {
    
  }

}
