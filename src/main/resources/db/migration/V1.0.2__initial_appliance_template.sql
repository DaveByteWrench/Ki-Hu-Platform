CREATE TYPE appliance_type_enum AS ENUM (
    'UPS',
    'AMBIENT_SENSOR'
);

create table if not exists appliances_templates (
	id uuid primary key not null,
	manufacturer varchar not null,
	model varchar not null,
    appliance_type appliance_type_enum not null
);

INSERT INTO platform.appliances_templates (id, manufacturer, model, appliance_type) VALUES
	 ('61a89aa6-c9eb-4915-a98c-e710575e696d', 'FSP', 'Champ 3k', 'UPS'),
	 ('aa09c2a8-dc43-4062-8d27-5aadfae23792', 'FSP', 'Champ 1k', 'UPS'),
	 ('fa9d8b9f-ba86-4e7f-8024-727124898ff6', 'IKEA', 'VINDSTYRKA', 'AMBIENT_SENSOR');