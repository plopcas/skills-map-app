import {Injectable}     from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Technology}         from './technology';
import {Observable}     from 'rxjs/Observable';

@Injectable()
export class TechnologyService {
    constructor(private http: Http) { }

    private _technologyUrl = 'http://localhost:8080/api/technology';

    getTechnologys() {
        return this.http.get(this._technologyUrl)
            .map(res => <Technology[]>res.json())
            .catch(this.handleError);
    }

    getTechnology(id: number) {
        return this.http.get(this._technologyUrl + "/" + id)
            .map(res => <Technology>res.json())
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}