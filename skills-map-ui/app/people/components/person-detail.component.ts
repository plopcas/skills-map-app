import { Component, OnInit } from 'angular2/core';
import { RouteParams } from 'angular2/router';

import { Profile } from './profile';
import { Person } from './person';
import { Product } from './product';
import { ProductExperience } from './product-experience';
import { Technology } from './technology';
import { TechnologyExperience } from './technology-experience';

import { PersonService } from '../services/person.service';
import { ProductService } from '../services/product.service';
import { ProductExperienceService } from '../services/product-experience.service';
import { TechnologyService } from '../services/technology.service';
import { TechnologyExperienceService } from '../services/technology-experience.service';

@Component({
    selector: 'my-person-detail',
    templateUrl: 'app/people/components/person-detail.component.html',
    styleUrls: ['app/people/components/person-detail.component.css']
})

export class PersonDetailComponent {
    profile: Profile = {};

    constructor(
        private _personService: PersonService,
        private _productService: ProductService,
        private _productExperienceService: ProductExperienceService,
        private _technologyService: TechnologyService,
        private _technologyExperienceService: TechnologyExperienceService,
        private _routeParams: RouteParams) {
    }

    ngOnInit() {
        var currYear = new Date().getFullYear();
        
        let personId = +this._routeParams.get('id');

        this._personService.getPerson(personId)
            .toPromise()
            .then(person => {
                this.profile.id = person.id;
                this.profile.name = person.name;
            });

        this.profile.productExperiences = [];
        this._productExperienceService.getProductExperienceByPerson(personId)
            .toPromise()
            .then(productExperiences => {
                productExperiences.forEach(productExperience => {
                    this._productService.getProduct(productExperience.productId)
                        .toPromise()
                        .then(product => {
                                productExperience.productName = product.name;
                                this.profile.productExperiences.push(productExperience);
                                this.profile.productExperiences = 
                                    this.profile.productExperiences.sort((n1,n2) => n1.year - n2.year);
                        })
                });
            });
        
        this.profile.technologyExperiences = [];
        this._technologyExperienceService.getTechnologyExperienceByPerson(personId)
            .toPromise()
            .then(technologyExperiences => {
                technologyExperiences.forEach(technologyExperience => {
                    this._technologyService.getTechnology(technologyExperience.technologyId)
                        .toPromise()
                        .then(technology => {
                            technologyExperience.technologyName = technology.name;
                            this.profile.technologyExperiences.push(technologyExperience);
                            this.profile.technologyExperiences = 
                                this.profile.technologyExperiences.sort((n1,n2) => n1.year - n2.year);
                        })
                });
            });
    }

    goBack() {
        window.history.back();
    }
}
