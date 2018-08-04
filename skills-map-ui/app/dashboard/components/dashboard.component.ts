import { Component, OnInit } from 'angular2/core';
import { Router } from 'angular2/router';

@Component({
    selector: 'my-dashboard',
    templateUrl: 'app/dashboard/components/dashboard.component.html',
    styleUrls: ['app/dashboard/components/dashboard.component.css']
})
export class DashboardComponent implements OnInit {
    constructor(
        private _router: Router) {
    }
    ngOnInit() {
    }
}