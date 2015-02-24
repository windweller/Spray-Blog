var gulp = require('gulp');
var browserify = require('browserify');
var source = require("vinyl-source-stream");
var watchify = require('watchify');
var livereload = require('gulp-livereload');
var gulpif = require('gulp-if');
var buffer = require('vinyl-buffer');
var glob = require("glob");
var _ = require("lodash");
var uglify = require('gulp-uglify');
var watch;

gulp.task('browserify-nowatch', function(){
  watch = false;
  browserifyShare();
});

gulp.task('browserify-watch', function(){
  watch = true;
  browserifyShare();
});

function browserifyShare(){
  var b = browserify({
    cache: {},
    packageCache: {},
    fullPaths: true
  });
  
  if(watch) {
    // if watch is enable, wrap this bundle inside watchify
    b = watchify(b);
    b.on('update', function(){
      bundleShare(b);
    });
  }

  glob("./views/js/scripts/*.js", {}, function (err, files) {
     
    b.add('./views/js/home.js'); //main file

     _.forEach(files, function (file) {
      console.log(file);
       b.add(file);
     });

     bundleShare(b);
   });

}

function bundleShare(b) {
  b.bundle()
    .pipe(source('compressed.js'))
    .pipe(buffer())
    .pipe(uglify())
    .pipe(gulp.dest('./views/js/dist/'))
    .pipe(gulpif(watch, livereload()));
}

// define the browserify-watch as dependencies for this task
gulp.task('watch', ['browserify-watch'], function(){
  // watch other files, for example .less file
  gulp.watch('./less/*.less',
             ['compile-less']);

  // Start live reload server
  livereload.listen(35729);
});