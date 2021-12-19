import 'zone.js/dist/zone';
import 'core-js/es/reflect';
import 'core-js/proposals/reflect-metadata';

declare var Liferay: any;

export default function(rootId: string) {
	Liferay.Loader.require(
		'chatUserInterface@1.0.0/lib/main',
		(main: any) => {
			main.default(rootId);
		},
	);
}