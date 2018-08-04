import {Injectable}     from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Product}         from './product';
import {Observable}     from 'rxjs/Observable';

@Injectable()
export class ProductService {
    constructor(private http: Http) { }

    private _productUrl = 'http://localhost:8080/api/product';

    getProducts() {
        return this.http.get(this._productUrl)
            .map(res => <Product[]>res.json())
            .catch(this.handleError);
    }

    getProduct(id: number) {
        return this.http.get(this._productUrl + "/" + id)
            .map(res => <Product>res.json())
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}