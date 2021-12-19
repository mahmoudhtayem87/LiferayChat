import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";


declare const Liferay: any;


@Component({
	template: `
		<router-outlet></router-outlet>
	`
})
export class AppComponent implements OnInit{
	params: any;
	labels: any;
	public isActive = false;
	public get isSignedIn()
	{
		return Liferay.ThemeDisplay.isSignedIn();
	}
	constructor(private router: Router,private activeRoute:ActivatedRoute) {
		this.labels = {
			configuration: Liferay.Language.get('configuration'),
			portletNamespace: Liferay.Language.get('portlet-namespace'),
			contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}


	ngOnInit() {
		if(Liferay.ThemeDisplay.isSignedIn())
		{
			this.router.navigate(['/activeUsers']);
		}
	}


	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}