CREATE DATABASE IF NOT EXISTS datetimecalculator;

CREATE TABLE IF NOT EXISTS expression (
	id SERIAL PRIMARY KEY,
	date1 DATE,
	date2 DATE,
	value INT,
	operation INT,
	naturalLanguageOp INT,
	timeUnits INT,
	timeStamp TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	dataRetrivalOps INT,
	result VARCHAR(200)
);