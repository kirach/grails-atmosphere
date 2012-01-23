modules = {
    'atmosphere' {
        dependsOn 'jquery'
        resource id:'js', url:[plugin: 'atmosphere', dir:'js/jquery', file:"jquery.atmosphere.js"],
            disposition:'head', nominify: true
    }

}