#!/usr/bin/env bash
echo "Generating Allure report"
allure generate --clean
cp -r allure-report/history allure-results
allure serve
