import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterContract'
})
export class FilterProductsPipe implements PipeTransform {

  transform(contracts: Contract[], search: number): Contract[] {
    if(search === undefined) {
      return contracts;
    } else {
      return contracts.filter((contract, index) => {
        return contract.contractNo === search;
      });
    }
  }

}