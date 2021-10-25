CREATE DATABASE movies;
USE movies;

-- Database of movie-rating website
/* Delete the tables if they already exist */
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS reviewer;
DROP TABLE IF EXISTS rating;

/* Create the schema for our tables */
CREATE TABLE movie
(
    mid      int,
    title    text,
    year     int,
    director text
);
CREATE TABLE reviewer
(
    rid  int,
    name text
);
CREATE TABLE rating
(
    rid        int,
    mid        int,
    stars      int,
    ratingdate date
);

/* Populate the tables with our data */
INSERT INTO movie
VALUES (101, 'Gone with the Wind', 1939, 'Victor Fleming');
INSERT INTO movie
VALUES (102, 'Star Wars', 1977, 'George Lucas');
INSERT INTO movie
VALUES (103, 'The Sound of Music', 1965, 'Robert Wise');
INSERT INTO movie
VALUES (104, 'E.T.', 1982, 'Steven Spielberg');
INSERT INTO movie
VALUES (105, 'Titanic', 1997, 'James Cameron');
INSERT INTO movie
VALUES (106, 'Snow White', 1937, NULL);
INSERT INTO movie
VALUES (107, 'Avatar', 2009, 'James Cameron');
INSERT INTO movie
VALUES (108, 'Raiders of the Lost Ark', 1981, 'Steven Spielberg');

INSERT INTO reviewer
VALUES (201, 'Sarah Martinez');
INSERT INTO reviewer
VALUES (202, 'Daniel Lewis');
INSERT INTO reviewer
VALUES (203, 'Brittany Harris');
INSERT INTO reviewer
VALUES (204, 'Mike Anderson');
INSERT INTO reviewer
VALUES (205, 'Chris Jackson');
INSERT INTO reviewer
VALUES (206, 'Elizabeth Thomas');
INSERT INTO reviewer
VALUES (207, 'James Cameron');
INSERT INTO reviewer
VALUES (208, 'Ashley White');

INSERT INTO rating
VALUES (201, 101, 2, '2011-01-22');
INSERT INTO rating
VALUES (201, 101, 4, '2011-01-27');
INSERT INTO rating
VALUES (202, 106, 4, NULL);
INSERT INTO rating
VALUES (203, 103, 2, '2011-01-20');
INSERT INTO rating
VALUES (203, 108, 4, '2011-01-12');
INSERT INTO rating
VALUES (203, 108, 2, '2011-01-30');
INSERT INTO rating
VALUES (204, 101, 3, '2011-01-09');
INSERT INTO rating
VALUES (205, 103, 3, '2011-01-27');
INSERT INTO rating
VALUES (205, 104, 2, '2011-01-22');
INSERT INTO rating
VALUES (205, 108, 4, NULL);
INSERT INTO rating
VALUES (206, 107, 3, '2011-01-15');
INSERT INTO rating
VALUES (206, 106, 5, '2011-01-19');
INSERT INTO rating
VALUES (207, 107, 5, '2011-01-20');
INSERT INTO rating
VALUES (208, 104, 3, '2011-01-02');


-- # Find the titles of all movies directed by Steven Spielberg.
SELECT title
FROM movie
WHERE director = 'Steven Spielberg';

-- # Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order.
ALTER TABLE movie
    ADD PRIMARY KEY (mid);

ALTER TABLE rating
    ADD FOREIGN KEY (mid)
        REFERENCES movie (mid);

SELECT DISTINCT year
FROM movie
         LEFT JOIN rating ON movie.mid = rating.mid
WHERE stars > 3
ORDER BY year ASC;

# Find the titles of all movies that have no ratings.
SELECT title
FROM movie
         LEFT JOIN rating ON movie.mid = rating.mid
WHERE stars IS NULL;

-- #  Some reviewers didn’t provide a date with their rating. Find the names of all reviewers who have
-- #  ratings with a NULL value for the date.
DESCRIBE reviewer;

ALTER TABLE reviewer
    ADD PRIMARY KEY (rid);

ALTER TABLE rating
    ADD FOREIGN KEY (rid)
        REFERENCES reviewer (rid);

DESCRIBE rating;

SELECT DISTINCT name
FROM reviewer
         LEFT JOIN rating ON reviewer.rid = rating.rid
WHERE ratingdate IS NULL;

# Write a query to return the ratings data in a more readable format: reviewer name, movie title,
# stars, and ratingDate. Also, sort the data, first by reviewer name, then by movie title,
# and lastly by number of stars.


SELECT name, title, stars, ratingdate
FROM rating
         LEFT JOIN reviewer ON reviewer.rid = rating.rid
         LEFT JOIN movie ON movie.mid = rating.mid
ORDER BY name ASC, title ASC, stars ASC;


-- # For all cases where the same reviewer rated the same movie twice and gave it a higher
-- # rating the second time, return the reviewer’s name and the title of the movie.
SELECT name, title
FROM rating AS l
         LEFT JOIN rating AS r ON l.rid = r.rid
         LEFT JOIN movie ON movie.mid = l.mid
         LEFT JOIN reviewer ON reviewer.rid = l.rid
WHERE l.stars < r.stars
  AND l.ratingdate < r.ratingdate
  AND l.mid = r.mid
ORDER BY l.rid ASC, l.ratingdate ASC;


# For each movie that has at least one rating, find the highest number of stars that movie received.
# Return the movie title and number of stars. Sort by movie title.

SELECT title, MAX(stars)
FROM rating
         INNER JOIN movie ON movie.mid = rating.mid
GROUP BY title
HAVING COUNT(*) > 1
ORDER BY title ASC;

