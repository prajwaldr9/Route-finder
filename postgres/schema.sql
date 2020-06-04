CREATE TABLE ROUTE(id serial PRIMARY KEY,
				   start_location varchar(80) NOT NULL,
				   from_location varchar(80) NOT NULL,
				   to_location varchar(80) NOT NULL,
				   via_routes varchar(255) NOT NULL,
				   dept_time varchar(255) NOT NULL);