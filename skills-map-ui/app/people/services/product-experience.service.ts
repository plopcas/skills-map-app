import {Injectable}     from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {ProductExperience}         from './productExperience';
import {Observable}     from 'rxjs/Observable';

@Injectable()
export class ProductExperienceService {
    constructor(private http: Http) { }

    private _productExperienceUrl = 'http://localhost:8080/api/productExperience';

    getProductExperiences() {
        return this.http.get(this._productExperienceUrl)
            .map(res => <ProductExperience[]>res.json())
            .catch(this.handleError);
    }

    getProductExperienceByPerson(personId: number) {
        return this.http.get(this._productExperienceUrl + "/search?personId=" + personId)
            .map(res => <ProductExperience[]>res.json())
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}