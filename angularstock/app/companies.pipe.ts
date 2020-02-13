import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'companies'
})
export class CompaniesPipe implements PipeTransform {
  transform(companies: Company[], search: string): Company[] {
    if (search === undefined) {
    return companies;
  }
    // tslint:disable-next-line: variable-name
    return companies.filter((company, _index) => {
    return company.companyName.toLowerCase().includes(search.toLowerCase());
  });
}
}
