load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

RULES_JVM_EXTERNAL_TAG = "3.1"
RULES_JVM_EXTERNAL_SHA = "e246373de2353f3d34d35814947aa8b7d0dd1a58c2f7a6c41cfeaff3007c2d14"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)
load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "junit:junit:4.12",
        "org.hamcrest:hamcrest-library:1.3",
        "com.google.guava:guava:28.0-jre",
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

git_repository(
  name = "com_github_davido_bazlets",
  remote = "https://github.com/GerritCodeReview/bazlets.git",
  commit = "ed210c9f7132b2e1b21d993b85bc55e9623ea4e2",
)
