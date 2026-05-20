INSERT INTO modalities (name) VALUES
('Mojang'),
('Fuuin Fu'),
('Full Dell');

INSERT INTO plans (modality_id, name, monthly_price) VALUES
(1, 'YEARLY', 102.35),
(1, 'MONTHLY', 11.95),
(2, 'MONTHLY', 9.95),
(3, 'YEARLY', 123.99),
(3, 'MONTHLY', 13.45);

INSERT INTO graduations (modality_id, name) VALUES
(1, 'faixa azul'),
(1, 'faixa marrom'),
(3, 'xifu dell');

INSERT INTO students (
id,
tax_id,
name,
birthdate,
gender,
email,
main_contact_number,
spare_contact_number,
address_street,
address_number,
address_complement,
address_neighborhood,
address_city,
address_state,
address_zip_code
) VALUES (
999,
'1823.3828.2828-3',
'jojo',
'2020-10-31',
'F',
'ahshdjaja@gmail.com',
'239-939-9392',
'555-555-1035',
'purr ave.',
'35',
'near gas station',
'golang land',
'xique xique bahia',
'ba',
'28293838192-933'
);
