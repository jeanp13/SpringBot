module.exports = function(grunt) {

	grunt
			.initConfig({
				bowercopy : {
					// Single file
					/*
					 * test : { options : { destPrefix :
					 * 'src/main/webapp/static' }, files : { 'js/jquery.min.js' :
					 * 'jquery/dist/jquery.min.js', 'js/angular.min.js' :
					 * 'angular/angular.min.js' } },
					 */
					// Entire folders
					folders : {
						files : {
							// font awesome
							'src/main/webapp/static/font-awesome/css' : 'font-awesome/css/font-awesome.min.css',
							'src/main/webapp/static/font-awesome/fonts' : 'font-awesome/fonts',
							
							'src/main/webapp/static/angular' : 'angular-local-storage/dist/angular-local-storage.min.js',
							'src/main/webapp/static/jquery' : 'jquery/dist/jquery.min.js',
							'src/main/webapp/static/angular/angular.min.js' : 'angular/angular.min.js',
							'src/main/webapp/static/angular/angular-route.min.js' : 'angular-route/angular-route.min.js',
							'src/main/webapp/static/bootstrap' : 'bootstrap/dist'
						}
					}
				},
				includeSource : {
					options : {
						basePath : './src/main/webapp',
						baseUrl : '/',
					},
					myTarget : {
						files : {
							'./src/main/webapp/templates/index.html' : './src/main/webapp/templates/index.html'
						}
					}
				}
			});

	grunt.loadNpmTasks('grunt-bowercopy');
	grunt.loadNpmTasks('grunt-wiredep');
	grunt.loadNpmTasks('grunt-injector');
	grunt.loadNpmTasks('grunt-include-source');

	grunt.registerTask('default', [ 'wiredep' ]);
};