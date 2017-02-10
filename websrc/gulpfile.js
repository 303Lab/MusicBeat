/**
 * Gulp Configure
 *
 * @author windawings
 * @time.creation 2017/01/22 17:53
 * @version 1.0.0
 * @since 1.0.0
 */

"use strict";

var gulp        = require("gulp");
var $           = require("gulp-load-plugins")();
var browserSync = require("browser-sync");
var del         = require("del");
var reload      = browserSync.reload;
var production  = false;

var output = $.if(production, "public", "../src/main/webapp/WEB-INF/resources");

var path = {
    vendorJs: [
        // "node_modules/satellizer/dist/satellizer.min.js",
        $.if(production, "node_modules/jquery/dist/jquery.min.js", "node_modules/jquery/dist/jquery.js"),
        $.if(production, "node_modules/angular/angular.min.js", "node_modules/angular/angular.js"),
        $.if(production, "node_modules/angular-*/**/angular-*.min.js", "node_modules/angular-*/**/angular-*.js"),
        $.if(production, "node_modules/ng-dialog/js/ngDialog.min.js", "node_modules/ng-dialog/js/ngDialog.js"),
        $.if(production, "node_modules/ngStorage/ngStorage.min.js", "node_modules/ngStorage/ngStorage.js"),
    ],
    vendorCss: [
        $.if(production, "node_modules/bootstrap/dist/css/bootstrap.min.css", "node_modules/bootstrap/dist/css/bootstrap.css"),
        $.if(production, "node_modules/ng-dialog/css/ngDialog.css", "node_modules/ng-dialog/css/ngDialog.min.css"),
        $.if(production, "node_modules/ng-dialog/css/ngDialog-theme-default.css", "node_modules/ng-dialog/css/ngDialog-theme-default.min.css"),
        $.if(production, "node_modules/ng-dialog/css/ngDialog-theme-plain.css", "node_modules/ng-dialog/css/ngDialog-theme-plain.min.css"),
    ],
    appJs: ["app/**/*.module.js", "app/**/*.js"],
    appCss: ["app/static/**/*"],
    font: ["node_modules/bootstrap/fonts/*"],
    image: ["app/static/img/*"],
    jade: ["app/modules/**/*.pug"]
};

var o = {
    jade: output + "/tpls",
    fonts: output + "/fonts",
    css: output + "/css",
    js: output + "/js",
    image: output + "/img",
    appCssName: "app.css",
    vendorCss: "vendor.css",
    appJsName: "app.js",
    vendorJs: "vendor.js",
    watchHtml: output + "/tpls/**/*.html",
    watchCss: output + "/css/**/*.css",
    watchJs: output + "/js/**/*.js",
    watchImage: output + "/img/**/*",
    watchFont: output + "/fonts/**/*"
};

// Launch Browser & Watch Files For change
gulp.task("browser-sync", function() {
    browserSync.init([o.watchCss, o.watchJs, o.watchHtml, o.watchImage, o.watchFont], {
        server: {
            baseDir: output,
            index: "tpls/home.html"
        }
    }, function(err, bs) {
        $.util.log(err + "\n\t" + bs.options.getIn(["urls", "local"]));
    });

    gulp.watch(["app/static/css/**/*.css", "app/static/scss/**/*.scss"], ["css-min"]);
    gulp.watch(["app/static/img/*"], ["image"]);
    gulp.watch(["node_modules/bootstrap/fonts/*"], ["font"]);
    gulp.watch(["app/**/*.js"], ["scripts-app"]);
    gulp.watch(["app/modules/**/*.pug"], ["jade"]);
    gulp.watch("*.html").on("change", browserSync.reload);
    // gulp.watch(["app/views/**/*.jade"], ["jade"], function(event) {
    //     $.util.log("File " + event.path + " was " + event.type + ", running tasks...")
    // });
});

// Concatenate Font
gulp.task("font", function () {
    return gulp.src(path.font)
        .pipe($.changed(o.watchFont))
        .pipe(gulp.dest(o.fonts));
});

// Concatenate Jade
gulp.task("jade", function () {
    return gulp.src(path.jade)
        .pipe($.plumber())
        .pipe($.changed(o.watchHtml))
        .pipe($.pug())
        .pipe($.if(production, $.htmlmin(), $.htmlBeautify({indent_size: 4, indent_char: " ", unformatted: true, extra_liners: []})))
        .pipe($.rename({dirname: ""}))
        .pipe(gulp.dest(o.jade))
        .pipe(reload({stream: true}));
});

// Concatenate CSS
gulp.task("css", function() {
    return gulp.src(path.vendorCss)
        .pipe($.changed(o.watchCss))
        .pipe($.concat(o.vendorCss))
        .pipe(gulp.dest(o.css))
        .pipe(reload({stream: true}));
});

// Compile Sass/Scss & Minify css
gulp.task("css-min", function () {
    const scssFilter = $.filter("**/*.scss", {restore: true});
    const cssFilter = $.filter("**/*.css", {restore: true});

    return gulp.src(path.appCss)
        .pipe($.plumber())
        .pipe($.changed(o.watchCss))
        .pipe(scssFilter)
        .pipe($.sass(), $.sass.logError)
        .pipe(scssFilter.restore)
        .pipe(cssFilter)
        .pipe($.concat(o.appCssName))
        .pipe($.if(production, $.minifyCss()))
        .pipe($.rename({dirname: ""}))
        .pipe(gulp.dest(o.css))
        .pipe(reload({stream: true}));
});

// Concatenate Vendor JS
gulp.task("scripts-vendor", function() {
    return gulp.src(path.vendorJs)
        .pipe($.changed(o.watchJs))
        .pipe($.concat(o.vendorJs))
        .pipe(gulp.dest(o.js))
        .pipe(reload({stream: true}));
});

// Concatenate JS & Minify JS
gulp.task("scripts-app", function() {
    return gulp.src(path.appJs)
        .pipe($.plumber())
        .pipe($.changed(o.watchJs))
        .pipe($.concat(o.appJsName))
        .pipe($.if(production, $.stripDebug()))
        .pipe($.wrap("(function() {\n\"use strict\";\n<%= contents %>\n})();"))
        .pipe($.if(production, $.ngAnnotate()))
        .pipe($.if(production, $.ngmin({dynamic: false})))
        .pipe($.if(production, $.uglify({outSourceMap: false}), $.beautify({indent_size: 4})))
        .pipe(gulp.dest(o.js))
        .pipe(reload({stream: true}));
});

// Concatenate & Minify Image
gulp.task("image", function () {
    return gulp.src(path.image)
        .pipe($.changed(o.watchImage))
        .pipe($.imagemin({
            progressive: true,
            svgo$: [{removeViewBox: false}],
            use: [$.pngquant()]
        }))
        .pipe(gulp.dest(o.image))
        .pipe(reload({stream: true}));
});

// Test JS
gulp.task("jshint", function () {
    return gulp.src(path.appJs)
        .pipe($.jshint())
        .pipe($.jshint.reporter("default"));
});

// Clean Public Src
gulp.task("clean", function () {
    var delFiles = [o.css, o.jade, o.js, o.image, o.fonts];
    $.if(production,
         del(delFiles, {force: true}),
         del(delFiles, {force: true}, {dryRun: true})
    );
});

// Default Task
gulp.task("default", ["jshint", "clean"], function (cb) {
    $.sequence(["css", "scripts-vendor","css-min", "scripts-app", "image", "jade", "font"], cb);

    // Watch files changed
    gulp.watch(["app/static/css/**/*.css", "app/static/scss/**/*.scss"], ["css-min"]);
    gulp.watch(["app/static/img/*"], ["image"]);
    gulp.watch(["node_modules/bootstrap/fonts/*"], ["font"]);
    gulp.watch(["app/**/*.js"], ["scripts-app"]);
    gulp.watch(["app/modules/**/*.pug"], ["jade"]);
});

// Browser Task
gulp.task("browser", ["jshint", "clean"], function (cb) {
    $.sequence(["css", "scripts-vendor","css-min", "scripts-app", "image", "jade", "font"], "browser-sync", cb);
});

// Release Task
gulp.task("release", ["jshint", "clean"], function (cb) {
    $.sequence(["css", "scripts-vendor","css-min", "scripts-app", "image", "jade", "font"], cb);
});