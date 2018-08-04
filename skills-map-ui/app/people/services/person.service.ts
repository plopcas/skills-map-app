import {Injectable}     from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Person}         from './person';
import {Observable}     from 'rxjs/Observable';

@Injectable()
export class PersonService {
    constructor(private http: Http) { }

    private _personUrl = 'http://localhost:8080/api/person';

    getPersons() {
        return this.http.get(this._personUrl)
            .map(res => <Person[]>res.json())
            .catch(this.handleError);
    }

    getPerson(id: number) {
        return this.http.get(this._personUrl + "/" + id)
            .map(res => <Person>res.json())
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        // in a real world app, we may send the error to some remote logging infrastructure
        // instead of just logging it to the console
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}