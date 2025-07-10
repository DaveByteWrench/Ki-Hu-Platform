create table if not exists appliances_templates (
	id uuid primary key not null,
	manufacturer varchar not null,
	model varchar not null
);

INSERT INTO platform.appliances_templates (id,manufacturer,model) VALUES
	 ('61a89aa6-c9eb-4915-a98c-e710575e696d', 'FSP', 'Champ 3k'),
	 ('aa09c2a8-dc43-4062-8d27-5aadfae23792', 'FSP', 'Champ 1k'),
	 ('fa9d8b9f-ba86-4e7f-8024-727124898ff6', 'IKEA', 'VINDSTYRKA');