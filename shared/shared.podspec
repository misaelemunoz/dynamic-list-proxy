Pod::Spec.new do |spec|
    spec.name                     = 'shared'
    spec.version                  = '1.0.1'
    spec.homepage                 = 'https://github.com/misaelemunoz/dynamic-list-proxy'
    spec.source                   = { :http=> ''}
    spec.authors                  = 'Misael Munoz'
    spec.license                  = { :type => 'MIT', :text => 'License text'}
    spec.summary                  = 'iOS library for mapping dynamic list responses'
    spec.vendored_frameworks      = 'DynamicListProxy.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target    = '13.0'
    spec.static_framework         = true
    spec.xcconfig = {
        'ENABLE_USER_SCRIPT_SANDBOXING' => 'NO',
    }
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':shared',
        'PRODUCT_MODULE_NAME' => 'DynamicListProxy',
    }
                
    spec.script_phases = [
        {
            :name => 'Build shared',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
    spec.source = { :git => 'https://github.com/misaelemunoz/dynamic-list-proxy.git', :tag => '1.0.1' }
end