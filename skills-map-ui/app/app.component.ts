import { Component, enableProdMode } from 'angular2/core';
enableProdMode();
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';
import { HTTP_PROVIDERS } from 'angular2/http';

import { PersonService } from './people/services/person.service';
import { ProductService } from './people/services/product.service';
import { ProductExperienceService } from './people/services/product-experience.service';
import { TechnologyService } from './people/services/technology.service';
import { TechnologyExperienceService } from './people/services/technology-experience.service';

import { DashboardComponent } from './dashboard/components/dashboard.component';
import { PersonsComponent } from './people/components/persons.component';
import { PersonDetailComponent } from './people/components/person-detail.component';

@Component({
    selector: 'my-app',
    templateUrl: 'app/app.component.html',
    styleUrls: ['app/app.component.css'],
    directives: [ROUTER_DIRECTIVES],
    providers: [
        HTTP_PROVIDERS,
        ROUTER_PROVIDERS,
        PersonService,
        ProductService,
        ProductExperienceService,
        TechnologyService,
        TechnologyExperienceService
    ]
})
@RouteConfig([
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: DashboardComponent,
        useAsDefault: true
    },
    {
        path: '/person',
        name: 'Persons',
        component: PersonsComponent
    },
    {
        path: '/person/:id',
        name: 'PersonDetail',
        component: PersonDetailComponent
    }

])
export class AppComponent {
    title = 'Skills Map';
}
