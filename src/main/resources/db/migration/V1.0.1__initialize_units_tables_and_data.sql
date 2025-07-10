CREATE TYPE physical_quantity_enum AS ENUM (
    'VOLTAGE',
    'CURRENT',
    'RESISTANCE',
    'HUMIDITY',
    'PARTICULATE_MATTER',
    'TEMPERATURE',
    'POWER'
);

create table if not exists units (
    id uuid not null primary key,
    full_name varchar not null,
    physical_quantity physical_quantity_enum NOT NULL,
    symbol varchar not null
);

INSERT INTO units (id, full_name, physical_quantity, symbol) VALUES
('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'VOLT', 'VOLTAGE', 'V'),
('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'AMPERE', 'CURRENT', 'A'),
('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'OHM', 'RESISTANCE', 'Ω'),
('d0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'RELATIVE_HUMIDITY', 'HUMIDITY', '%'),
('e0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'MIGROGRAMS_PER_VOLUME', 'PARTICULATE_MATTER', 'µg/m³'),
('f0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'CELSIUS', 'TEMPERATURE', '°C'),
('11eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'WATT', 'POWER', 'W'),
('12eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'FAHRENHEIT', 'TEMPERATURE', '°F'),
('13eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'KELVIN', 'TEMPERATURE', 'K');
