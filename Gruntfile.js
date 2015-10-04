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
							'src/main/webapp/static/jquery' : 'jquery/dist/jquery.min.js',
							'src/main/webapp/static/angular/angular.min.js' : 'angular/angular.min.js',

							'src/main/webapp/static/bootstrap' : 'bootstrap/dist'
						}
					}
				},
				injector : {
					/***********************************************************
					 * options : { destFile : [
					 * './src/main/webapp/templates/*.html' ], ignorePath :
					 * 'app/' }, files : { expand : true, cwd :
					 * 'src/main/webapp/static/', src : [ '
					 **********************************************************//* .css', '* *//*
													 * .js' ], dest :
													 * 'app/static/css', ext :
													 * '.css' }
													 */
					options : {
					// destFile : [ './src/main/webapp/templates/index.html' ],
					// ignorePath: 'app/'
					// min: true
					},
					local_dependencies : {
						files : {
							'./src/main/webapp/templates/index.html' : [
									'src/main/webapp/static/**/*.js',
									'src/main/webapp/static/**/*.css' ]
						}
					}
				/***************************************************************
				 * local_dependencies: { files: { expand : true, cwd :
				 * 'src/main/webapp/static/', src : [ '/static/
				 **************************************************************//*
											 * .css' ], dest : '/static/', ext:
											 * '.css'
											 * 
											 *  } }
											 */
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
				},
				wiredep : {
					task : {
						src : [ './src/main/webapp/templates/*.html' ]
					},
					ignorePath : '/../../../public'
				}
			});

	grunt.loadNpmTasks('grunt-bowercopy');
	grunt.loadNpmTasks('grunt-wiredep');
	grunt.loadNpmTasks('grunt-injector');
	grunt.loadNpmTasks('grunt-include-source');

	grunt.registerTask('default', [ 'wiredep' ]);
};