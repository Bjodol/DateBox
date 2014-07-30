import os
from flask import Flask, render_template
from flask.ext import assets

controller = Flask(__name__)
env = assets.Environment(controller)

# Tell flask-assets where to look for our javascript and css files.
env.load_path = [
    os.path.join(os.path.dirname(__file__), 'css'),
    os.path.join(os.path.dirname(__file__), 'angular'),
    os.path.join(os.path.dirname(__file__), 'bower_components'),
]

env.register(
    'js_all',
    assets.Bundle(
        'jquery/dist/jquery.js',
        'angular/angular.js',
        'angular-bootstrap/ui-bootstrap-tpls.min.js',
        'angular-ui-router/release/angular-ui-router.js',
        'home-ctrl.js',
        'datebox.js',
        #filters='jsmin',
        output='datebox.js'
    )
)

env.register(
    'css_all',
    assets.Bundle(
        'bootstrap/dist/css/bootstrap.css',
        'datebox.css',
        #filters='cssmin',
        output='datebox.css'
    )
)

@controller.route("/")
def index():
    return render_template('index.html')

if __name__ == '__main__':
    controller.run(debug=True)