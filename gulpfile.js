/* jshint camelcase: false */
'use strict';

var gulp = require('gulp'),
    jshint = require('gulp-jshint'),
    del = require('del'),
    es = require('event-stream'),
    wiredep = require('wiredep').stream,
    runSequence = require('run-sequence');

var yeoman = {
    app: 'src/main/resources/public/',
    templates: 'src/main/resources/templates/',
    dist: 'src/main/resources/public/dist/',
    port: 9000,
    apiPort: 8080,
    liveReloadPort: 35729
};

gulp.task('clean', function (cb) {
    del([yeoman.dist], cb);
});

gulp.task('copy', function () {
    return es.merge(
        gulp.src([yeoman.app + 'css/**', '!' + yeoman.app + '{css,css/**}']).
            pipe(gulp.dest(yeoman.dist + 'css/'))
    );
});

gulp.task('wiredep', ['wiredep:app']);

gulp.task('wiredep:app', function () {
    return gulp.src(yeoman.app + 'index.html')
        .pipe(wiredep())
        .pipe(gulp.dest('src/main/resources/templates'));
});


gulp.task('process_scripts', ['wiredep:app']);

gulp.task('build', function () {
    runSequence('jshint', 'clean', 'copy');
});

gulp.task('jshint', function () {
    return gulp.src(['gulpfile.js', yeoman.app + 'js/**/*.js'])
        .pipe(jshint())
        .pipe(jshint.reporter('jshint-stylish'))
        .pipe(jshint.reporter('fail'));
});

gulp.task('default', function () {
    runSequence('build');
});
