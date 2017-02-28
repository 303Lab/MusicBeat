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

var output = $.if(production, "../src/main/webapp/WEB-INF/resources", "../src/main/webapp/WEB-INF/resources");

var path = {
    vendorJs: [
        $.if(production, "node_modules/jquery/dist/jquery.min.js", "node_modules/jquery/dist/jquery.js"),
        $.if(production, "node_modules/bootstarp/dist/js/bootstrap.min.js", "node_modules/bootstarp/dist/js/bootstrap.js"),
        $.if(production, "node_modules/angular/angular.min.js", "node_modules/angular/angular.js"),
        $.if(production, "node_modules/angular-*/**/angular-*.min.js", "node_modules/angular-*/**/angular-*.js"),
        $.if(production, "node_modules/angular-*/**/angular-*.tpls.min.js", "node_modules/angular-*/**/angular-*.tpls.js"),
        $.if(production, "node_modules/ng-dialog/js/ngDialog.min.js", "node_modules/ng-dialog/js/ngDialog.js"),
        $.if(production, "node_modules/ngStorage/ngStorage.min.js", "node_modules/ngStorage/ngStorage.js"),
        $.if(production, "node_modules/toastr/build/toastr.min.js", "node_modules/toastr/toastr.js"),
        "app/lib/js/owl.carousel.min.js",
        "app/lib/js/countdown.js",
        "app/lib/js/sweetalert.min.js",
        "app/lib/js/Nivo-Lightbox/nivo-lightbox.min.js",
        "app/lib/js/jquery.nouislider.all.min.js",
        "app/lib/js/scripts.js",
        "app/lib/js/html5shiv.min.js",
        "app/lib/js/respond.min.js",
        "app/lib/js/cityselect.js",
        "app/lib/js/APlayer.min.js"
    ],
    vendorCss: [
        "app/static/fonts/font-awesome/css/font-awesome.min.css",
        "app/static/fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css",
        "app/static/fonts/pe-icon-7-stroke/css/helper.css",
        "app/static/fonts/pe-icon-social/css/pe-icon-social.css",
        "app/static/fonts/pe-icon-social/css/helper.css",
        "app/static/fonts/quicksand-dash/css/stylesheet.css",
        $.if(production, "node_modules/bootstrap/dist/css/bootstrap.min.css", "node_modules/bootstrap/dist/css/bootstrap.css"),
        $.if(production, "node_modules/ng-dialog/css/ngDialog.min.css", "node_modules/ng-dialog/css/ngDialog.css"),
        $.if(production, "node_modules/ng-dialog/css/ngDialog-theme-default.min.css", "node_modules/ng-dialog/css/ngDialog-theme-default.css"),
        $.if(production, "node_modules/ng-dialog/css/ngDialog-theme-plain.min.css", "node_modules/ng-dialog/css/ngDialog-theme-plain.css"),
        $.if(production, "node_modules/angular-*/**/angular-*.min.css", "node_modules/angular-*/**/angular-*.css"),
        "app/lib/css/owl.carousel.css",
        "app/lib/css/owl.theme.default.css",
        "app/lib/css/animate.min.css",
        "app/lib/css/jquery.nouislider.min.css",
    ],
    appJs: [
        "app/**/*.module.js",
        "app/**/*.config.js",
        "app/**/*.provider.js",
        "app/**/*.route.js",
        "app/**/*.filter.js",
        "app/**/*.service.js",
        "app/**/*.directive.js",
        "app/**/*.controller.js",
        "app/**/*.script.js",
        "!app/lib/**/*.js",
        "!app/static/**/*"
    ],
    appCss: [
        "app/static/css/sweetalert.css",
        "app/static/css/style.css",
        "app/static/css/main.css",
        "app/static/css/*.css",
    ],
    font: ["node_modules/bootstrap/fonts/*",
           "app/static/fonts/font-awesome/fonts/*",
           "app/static/fonts/pe-icon-7-stroke/fonts/*",
           "app/static/fonts/pe-icon-social/fonts/*",
           "app/static/fonts/quicksand-dash/fonts/*",
    ],
    image: ["app/static/img/*"],
    jade: ["app/modules/**/*.pug"],
    html: ["app/modules/**/*.html"],
};

var o = {
    jade: output + "/tpls",
    fonts: output + "/fonts",
    css: output + "/css",
    js: output + "/js",
    image: output + "/images",
    appCssName: "app.css",
    vendorCss: "vendor.css",
    appJsName: "app.js",
    vendorJs: "vendor.js",
    watchHtml: output + "/tpls/**/*.html",
    watchCss: output + "/css/**/*.css",
    watchJs: output + "/js/**/*.js",
    watchImage: output + "/images/**/*",
    watchFont: output + "/fonts/**/*",
};

// Launch Browser & Watch Files For change
gulp.task("browser-sync", function() {
    browserSync.init([o.watchCss, o.watchJs, o.watchHtml, o.watchImage, o.watchFont], {
        server: {
            baseDir: output,
            index: "tpls/index.html"
        }
    }, function(err, bs) {
        $.util.log(err + "\n\t" + bs.options.getIn(["urls", "local"]));
    });

    gulp.watch(["app/static/css/**/*.css", "app/static/scss/**/*.scss"], ["css-min"]);
    gulp.watch(["app/static/img/*"], ["image"]);
    gulp.watch(["node_modules/bootstrap/fonts/*", "app/modules/static/fonts/**/*"], ["font"]);
    gulp.watch(["app/**/*.js"], ["scripts-app"]);
    gulp.watch(["app/modules/**/*.pug"], ["jade"]);
    gulp.watch(["app/modules/**/*.html"], ["html"]);
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

// Concatenate Jade
gulp.task("html", function () {
    return gulp.src(path.html)
        .pipe($.plumber())
        .pipe($.changed(o.watchHtml))
        .pipe($.if(production, $.htmlmin(), $.htmlBeautify({indent_size: 4, indent_char: " ", unformatted: true, extra_liners: []})))
        .pipe($.rename({dirname: ""}))
        .pipe(gulp.dest(o.jade))
        .pipe(reload({stream: true}));
});

// Concatenate 404 Page
gulp.task("404", function() {

    gulp.src(["app/lib/css/404.css"])
        .pipe($.plumber())
        .pipe($.changed(o.watchCss))
        .pipe(gulp.dest(o.css))
        .pipe(reload({stream: true}));

    return gulp.src(["app/lib/js/modernizr.js", "app/lib/js/404.js"])
            .pipe($.plumber())
            .pipe($.changed(o.watchJs))
            .pipe(gulp.dest(o.js))
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
    $.sequence(["css", "scripts-vendor","css-min", "scripts-app", "image", "jade", "font", "html", "404"], cb);

    // Watch files changed
    gulp.watch(["app/static/css/**/*.css", "app/static/scss/**/*.scss"], ["css-min"]);
    gulp.watch(["app/static/img/*"], ["image"]);
    gulp.watch(["node_modules/bootstrap/fonts/*", "app/modules/static/fonts/**/*"], ["font"]);
    gulp.watch(["app/**/*.js"], ["scripts-app"]);
    gulp.watch(["app/modules/**/*.pug"], ["jade"]);
    gulp.watch(["app/modules/**/*.html"], ["html"]);
});

// Browser Task
gulp.task("browser", ["jshint", "clean"], function (cb) {
    $.sequence(["css", "scripts-vendor","css-min", "scripts-app", "image", "jade", "font", "html", "404"], "browser-sync", cb);
});

// Release Task
gulp.task("release", ["jshint", "clean"], function (cb) {
    $.sequence(["css", "scripts-vendor","css-min", "scripts-app", "image", "jade", "font", "html", "404"], cb);
});