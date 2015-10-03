module.exports = function(grunt) {

  grunt.loadNpmTasks('grunt-wiredep');
  //grunt.loadNpmTasks('grunt-contrib-watch');

  grunt.initConfig({
    wiredep: {
      task: {
        src: ['./src/main/webapp/WEB-INF/templates/*.html']
      }
    }
  });

  grunt.registerTask('default', ['wiredep']);
};