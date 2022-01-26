# Ignore inline messages which lay outside a diff's range of PR
github.dismiss_out_of_range_messages

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

ktlint.lint
junit.parse "/path/to/output.xml"
junit.report

android_lint.skip_gradle_task = true
android_lint.report_file = "build/reports/lint/lint-results.xml"
android_lint.lint(inline_mode: true)
