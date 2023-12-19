# MapReduceAnalysis

Our project is a map reduce application that performs sentiment analysis on GitHub pull request comments. Sentiment analysis is the process of identifying and extracting the emotional tone and attitude of a text, such as positive, negative, or neutral. We use Apache Hadoop’s MapReduce framework to process large-scale data sets of comments from GitHub repositories. Our project aims to provide useful insights into the feedback and opinions of developers and users on different software projects.

# Analysis
1. Identify Negative Comments in Specific Languages:
  ● Analysis Task: Understand the distribution of negative comments across different programming languages used in GitHub pull requests.
  ● Main Task: Identify the number of negative comments in specific languages, sorted in descending order.
  ● Helper Task: Extract language information from the dataset, filter comments with negative sentiment, and categorize them based on languages. Utilize sorting algorithms to     arrange the languages in descending order of negative comments count.  
2. Determine Author with Frequent Negative Comments:
  ● Analysis Task: Pinpoint specific authors who consistently contribute negative comments to GitHub pull requests.
  ● Main Task: Determine the author who frequently makes negative comments.
  ● Helper Task: Group comments by authors, filter negative comments, and calculate the frequency of negative comments for each author. Identify the author with the highest   frequency of negative comments.
3. Analyze Sentiment Trends Over Time:
  ● Analysis Task: Discover patterns and trends in sentiment over time to understand the emotional dynamics of the developer community across different periods.
  ● Main Task: Analyze sentiment trends over time, identifying specific periods when sentiment is notably positive or negative.
  ● Helper Task: Extract timestamps from the dataset, aggregate comments based on time intervals (e.g., daily, weekly), and calculate the sentiment polarity for each
  interval. Visualize the sentiment trends over time to identify patterns of positive or negative sentiment fluctuation
