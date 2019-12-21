CREATE DATABASE IF NOT EXISTS `tv-shows`;

USE `tv-shows`;

DROP TABLE IF EXISTS tvseries;

CREATE TABLE IF NOT EXISTS tvseries(
	id INTEGER PRIMARY KEY,
	title TEXT,
    `year` INTEGER,
    genre TEXT,
    `description` TEXT
);

INSERT INTO tvseries(id, title, year, genre, description) VALUES (1, "The Expanse", 2015, "Sci-Fi", "A thriller set two hundred years in the future, The Expanse follows the case of a missing young woman who brings a hardened detective and a rogue ship's captain together in a race across the solar system to expose the greatest conspiracy in human history.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (2, "Westworld", 2016, "Sci-Fi", "Set at the intersection of the near future and the re-imagined past, explore a world in which every human appetite can be indulged without consequence.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (3, "Black Sails", 2014, "Adventure", "Follows Captain Flint and his pirates twenty years prior to Robert Louis Stevenson's classic novel Treasure Island.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (4, "Cowboy Bebop", 1998, "Anime", "Spike Spiegel is a bounty hunter in the far future with an easy going attitude. Together with his partner, Jet Black, and later Faye Valentine, they go from job to job across the galaxy looking for the high priced fugitives to bag.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (5, "Game of Thrones", 2011, "Fantasy", "Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (6, "Breaking Bad", 2008, "Crime", "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (7, "Lost", 2004, "Mystery", "The survivors of a plane crash are forced to work together in order to survive on a seemingly deserted tropical island.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (8, "Pushing Daisies", 2007, "Comedy-Drama", "A pie-maker, with the power to bring dead people back to life, solves murder mysteries with his alive-again childhood sweetheart, a cynical private investigator, and a lovesick waitress.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (9, "Attack on Titan", 2013, "Anime", "After his hometown is destroyed and his mother is killed, young Eren Yeager vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (10, "Fullmetal Alchemist: Brotherhood", 2009, "Anime", "Two brothers search for a Philosopher's Stone after an attempt to revive their deceased mother goes awry and leaves them in damaged physical forms.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (11, "Fringe", 2008, "Sci-Fi", "An F.B.I. agent is forced to work with an institutionalized scientist and his son in order to rationalize a brewing storm of unexplained phenomena.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (12, "American Gods", 2017, "Fantasy", "A recently released ex-convict named Shadow meets a mysterious man who calls himself 'Wednesday' and who knows more than he first seems to about Shadow's life and past.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (13, "Baccano!", 2007, "Anime", "A crazy fantasy caper involving alchemists, immortals, gangsters, outlaws and an elixir of immortality, spread over several decades.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (14, "The Blacklist", 2013, "Crime", "A new FBI profiler, Elizabeth Keen, has her entire life uprooted when a mysterious criminal, Raymond Reddington, who has eluded capture for decades, turns himself in and insists on speaking only to her.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (15, "Supernatural", 2005, "Fantasy", "The story revolves around two brothers, Sam and Dean Winchester as they follow their father's footsteps, hunting down evil supernatural creatures such as monsters, demons, and even fallen gods while trying to save innocent people along the way.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (16, "Samurai Champloo", 2004, "Anime", "Fuu, a waitress who works in a teahouse, rescues two master swordsmen, Mugen and Jin, from their execution to help her find the 'samurai who smells of sunflowers.'");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (17, "Shameless US", 2011, "Comedy-Drama", "Shameless is the story of a family of six kids and their drunk and selfish father. The eldest daughter Fiona has to raise the rest of the family on her own. Meet the fabulously dysfunctional Gallagher family.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (18, "Psycho-Pass", 2012, "Anime", "Believing in humanity and order, policewoman Akane Tsunemori obeys the ruling, computerized, precognitive Sibyl System. But when she faces a criminal mastermind who can elude this 'perfect' system, she questions both Sibyl and herself.");
INSERT INTO tvseries(id, title, year, genre, description) VALUES (19, "Watchmen", 2019, "Mystery", "Set in an alternate history where masked vigilantes are treated as outlaws, Watchmen embraces the nostalgia of the original groundbreaking graphic novel of the same name, while attempting to break new ground of its own.");
