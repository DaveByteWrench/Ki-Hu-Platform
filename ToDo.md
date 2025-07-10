# Changelog Journal

## Core
- [ ] Add application basic settings
- [ ] Data migration is handled by Flyway

## Hubs
- [ ] When the hub is started for the first time, runs the flyway migrations and initializes hub according with the settings
- [ ] Api to get the Hub information
- [ ] The hub is provisioned with the application in the application configuration

## Rooms
- [ ] Api to get the list of the rooms in the hub
- [ ] Api to create a new room

## Appliances
- [ ] Get the list of appliances, not templates
- [ ] Allow appliance provisioning
- [ ] Send message when new appliance is provisioned
- [ ] Run a scheduled task to send a snapshot of provisioned appliances
- [ ] Add an api to allow zigbee pairing sending message to zigbee2mqtt platform
- [ ] API to get a list of available templates

## Telemetries
- [ ] Add endpoint to request telemetries in a date range

## Commands
- [ ] Add endpoint to send a command to the appliance

## Alarms
- [ ] Create an CRUD API to allow thresholds management for each capability
- [ ] When the threshold is created or updated or removed send a message to kafka