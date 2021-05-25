CREATE NEW DATABASE ST04;

CREATE TABLE Batch_report (

                             batch_id SERIAL NOT NULL,
                             product_type TEXT NOT NULL,
                             time TIMESTAMPTZ NOT NULL,
                             temperature DOUBLE PRECISION NOT NULL,
                             humidity DOUBLE PRECISION NOT NULL,
                             acceptable_products FLOAT NOT NULL,
                             defective_products FLOAT NOT NULL,
                             total_products FLOAT NOT NULL,
                             state TEXT NOT NULL
);

SELECT create_distributed_hypertable ( 'Batch_report', 'time', 'state');
