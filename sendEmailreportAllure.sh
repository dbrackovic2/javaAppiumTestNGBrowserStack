#!/bin/bash
export TODAYS_DATE=`date +%Y-%m-%d_%H-%M`
echo ''${TODAYS_DATE}''
export BUILD_NUM="5.4.6"
echo $BUILD_NUM
echo \
'{
  "Messages":[
    {
      "From": {
        "Email": "email1",
        "Name": "name1"
      },
      "To": [
        {
          "Email": "email2",
          "Name": "name2"
        },
		{
          "Email": "email3",
          "Name": "name3"
        }
      ],
      "Subject": "QA build v'$BUILD_NUM' Automated Test Report",
      "HTMLPart": "<!DOCTYPE html><html><body><img src=\"https://xvwky.mjt.lu/tplimg/xvwky/b/xjxot/x33hu.png\" width=\"100\" height=\"100\"><p>Hello all,</p><p>This is the email for the latest automated test results.</p><p><b>Open this link to see <a href='https://app-automate.browserstack.com/dashboard/v2'>Browserstack report</a>.</b></p><p><b>Open this link to see <a href='http://10.21.25.10:9000/'>Allure report</a> for pass/fail results.</b></p><p>Best regards,</p><p>Name1</p></body></html>",
      "CustomID": "AppGettingStartedTest"
	}
  ]
}' > allure.json
curl -s \
-X POST \
--user "mailjetuser:key" \
https://api.mailjet.com/v3.1/send \
-H 'Content-Type: application/json' \
-d @allure.json