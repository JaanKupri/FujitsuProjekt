create table conditions(
    id int auto_increment,
    stationName varchar(255) NOT NULL,
    WMO long NOT NULL,
    temperature double NOT NULL,
    windSpeed double NOT NULL,
    phenomenon varchar(255)
)