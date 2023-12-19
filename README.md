# MapReduceAnalysis

Our project is a map reduce application that performs sentiment analysis on GitHub pull request comments. Sentiment analysis is the process of identifying and extracting the emotional tone and attitude of a text, such as positive, negative, or neutral. We use Apache Hadoop’s MapReduce framework to process large-scale data sets of comments from GitHub repositories. Our project aims to provide useful insights into the feedback and opinions of developers and users on different software projects.

# Dataset

The data set we will work with is the [GitHub Pull Requests Data](https://www.kaggle.com/datasets/stephangarland/ghtorrent-pull-requests), which contains essential metadata from GitHub pull requests and associated comments. The data set is hosted on
Kaggle, a platform for data science and machine learning. We can obtain the data set by downloading it as a zip file from the Kaggle website. The data set covers a period of five
months, from January to May 2019, and is divided into five CSV files, one for each month.

The selected dataset, "GitHub Pull Requests" Data, contains essential metadata from GitHub pull requests and associated comments, sourced from GHTorrent. The dataset
includes the following columns:
1. actor_login: GitHub username of the individual who performed the action (e.g., created pull request, commented).
2. actor_id: Unique identifier for the GitHub user performing the action.
3. comment_id: Unique identifier for the comment within the pull request.
4. comment: The text content of the comment made on the pull request.
5. repo: The repository to which the pull request belongs.
6. language: The programming language used in the repository.
7. author_login: GitHub username of the author of the pull request.
8. author_id: Unique identifier for the author of the pull request.
9. pr_id: Unique identifier for the pull request.
10. c_id: Unique identifier for the associated commit.
11. commit_date: The date when the associated commit was made.

This dataset provides a rich source of information for analyzing interactions within GitHub's collaborative development environment, enabling tasks such as sentiment analysis,
language-specific comment analysis, and user behavior pattern recognition. The dataset under consideration covers a period of 5 months and is substantial, occupying a space of 92.53 GB. Post-cleaning and removal of null values, the dataset is expected to be approximately between 40-50 GB. Crucially, its size and the project's potential deployment in
a production setting indicate an expected rapid growth; it could potentially expand into terabytes within a few years. This scalability underscores the need for advanced data
processing technologies like MapReduce and distributed computing methodologies. The dataset's focus on GitHub pull request comments is particularly valuable as it enables an
in-depth exploration of the emotional dynamics within the developer community. By employing sentiment analysis and emotion detection techniques, this data promises to yield
profound insights into the emotional tone of the open-source ecosystem, thereby fostering a more positive and productive environment for developers.

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
