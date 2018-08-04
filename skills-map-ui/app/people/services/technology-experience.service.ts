import {Injectable}     from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {TechnologyExperience}         from './technologyExperience';
import {Observable}     from 'rxjs/Observable';

@Injectable()
export class TechnologyExperienceService {
    constructor(private http: Http) { }

    private _technologyExperienceUrl = 'http://localhost:8080/api/technologyExperience';

    getTechnologyExperiences() {
        return this.http.get(this._technologyExperienceUrl)
            .map(res => <TechnologyExperience[]>res.json())
            .catch(this.handleError);
    }

    getTechnologyExperienceByPerson(personId: number) {
        return this.http.get(this._technologyExperienceUrl + "/search?personId=" + personId)
            .map(res => <TechnologyExperience[]>res.json())
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}