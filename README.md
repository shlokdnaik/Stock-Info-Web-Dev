Stock-Info-Web-Dev
==================

create a webpage that allows users to search for stock quotes and financial company news using the Yahoo! Finance Web Services and Yahoo! Company News RSS feed APIs, and the results will be displayed in tabular format.

A user will first open a page, called search_stock.php (or any valid page name), where he/she can enter a company symbol search about their stock quotes and their financial news.
The user should enter at least one of the company names. If the user did not enter anything clicked on “Search”, then an alert message should be shown with an appropriate message prompting the user inputting a company symbol.

When the input is valid, clicking on the Search button will send a request to your server for HelloWorldExample.php (or whatever your valid page name is) with the form data (You can use either GET or POST in the form action). This script will grab the data sent to it and send the search information to Yahoo! Finance Web Services and Yahoo! Company News RSS feed.
For company stock quote information, the PHP script will construct a web service URL to query the Yahoo! Finance Web service using the company symbol appropriately. The following URL retrieves Google stock financial information through its company symbol (GOOG).
● http://query.yahooapis.com/v1/public/yql?q=Select%20Name%2C%20Symbol%2C%20LastTradePriceOnly%2C%20Change%2C%20ChangeinPercent%2C%20PreviousClose%2C%20DaysLow%2C%20DaysHigh%2C%20Open%2C%20YearLow%2C%20YearHigh%2C%20Bid%2C%20Ask%2C%20AverageDailyVolume%2C%20OneyrTargetPrice%2C%20MarketCapitalization%2C%20Volume%2C%20Open%2C%20YearLow%20from%20yahoo.finance.quotes%20where%20symbol%3D%22GOOG%22&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys
● Note that URL contains the query:
select Name, Symbol, LastTradePriceOnly, Change, ChangeinPercent, PreviousClose, DaysLow, DaysHigh, Open, YearLow, YearHigh, Bid, Ask, AverageDailyVolume, OneyrTargetPrice, MarketCapitalization, Volume from yahoo.finance.quotes where symbol="GOOG".
● GOOG should be replaced with the value coming from the company symbol textbox
For company news, another PHP script will construct another web service URL to query the Yahoo! Company News RSS feed API using the company symbol. The following URL retrieves Google news through its company symbol (GOOG).
● http://feeds.finance.yahoo.com/rss/2.0/headline?s=GOOG&region=US&lang=en-US
● GOOG should be replaced with the value coming from the company

Each web service URL retrieves an XML response and your PHP script parses the returned XML files and extracts the necessary information to display data in a tabular format below the search form.

The returned XML from Yahoo Finance contains a set of information. Figure 5 shows an example of a returned XML from Yahoo Finance. We will guide you to extract specific information to fill up the necessary data in the result data. The top part of result table displays data extracted from Yahoo! Finance web service. The headline of top part shows company name and the company symbol and three numbers. Table 1 shows the mapping between the Yahoo! Finance XML File and the result table. The value of Change started either with + or - operator. If the value starts with + you should display the second and the third numbers in the headline in green and should show the UP green arrow.

-------------------------------
This was an assignment at a Web Tech Class at USC
