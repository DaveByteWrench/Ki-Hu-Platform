create schema if not exists platform;

create table if not exists hubs (
    id uuid primary key not null,
    hub_name varchar not null unique,
    hub_platform_version varchar not null,
    websocket_broker_url varchar not null
);

create table if not exists rooms (
	id uuid primary key not null,
	room_name varchar not null unique,
	hub_id uuid not null references hubs(id)
);

create table if not exists users (
    id uuid primary key not null,
    username varchar not null unique,
    user_secret varchar not null,
    user_group varchar not null,
    hub_id uuid not null references hubs(id)
);