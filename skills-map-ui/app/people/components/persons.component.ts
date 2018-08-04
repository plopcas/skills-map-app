import {Component, OnInit} from 'angular2/core';
import { Router } from 'angular2/router';

import {Person} from './person';
import {PersonDetailComponent} from './person-detail.component';
import {PersonService} from '../services/person.service';

@Component({
    selector: 'my-persons',
    templateUrl: 'app/people/components/persons.component.html',
    styleUrls: ['app/people/components/persons.component.css'],
    directives: [ PersonDetailComponent]
})

export class PersonsComponent implements OnInit {
  persons: Person[];
  selectedPerson: Person;
  errorMessage: string;

  constructor(
      private _router: Router,
      private _personService: PersonService) {
  }

  getPersons() {
      this._personService.getPersons().subscribe(
                     persons => this.persons = persons,
                     error =>  this.errorMessage = <any>error);
  }

  ngOnInit() {
      this.getPersons();
  }

  gotoDetail(person: Person) {
      this.selectedPerson = person;
      this._router.navigate(['PersonDetail', { id: this.selectedPerson.id }]);
    }
}
