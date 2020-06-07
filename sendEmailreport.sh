#!/bin/bash
rm emailable-report.html
cp test-output/emailable-report.html ./
export baseCode=`base64 emailable-report.html | tr -d '\n'`
echo "${baseCode}"
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
        "Name": "Name1"
      },
      "To": [
        {
          "Email": "email2",
          "Name": "Name2"
        },
		{
          "Email": "email3",
          "Name": "Name3"
        }
      ],
      "Subject": "QA Automation Test build '$BUILD_NUM' Email report '${TODAYS_DATE}'",
      "TextPart": "Automated test report",
      "HTMLPart": "<h3>Open this link to see browserstack report <a href='https://app-automate.browserstack.com/dashboard/v2'>Browserstack report</a>!</h3><br />Find the attachment in the mail for pass/fail results report!",
      "CustomID": "AppGettingStartedTest",
      "Attachments":[
	  {
		"ContentType": "text/html",
		"Filename": "emailable-report.html",
		"Base64Content": "'${baseCode}'"
	  }
	  ]
	}
  ]
}' > data.json
curl -s \
-X POST \
--user "mailjetuser:key" \
https://api.mailjet.com/v3.1/send \
-H 'Content-Type: application/json' \
-d @data.json