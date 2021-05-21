PGDMP     2    0                y            hrms    13.0    13.0 A               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    58139    hrms    DATABASE     a   CREATE DATABASE hrms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE hrms;
                postgres    false            �            1255    58141 4   validate_email_by_domain(integer, character varying)    FUNCTION       CREATE FUNCTION public.validate_email_by_domain(integer, character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $_$
DECLARE
	DECLARE user_email_address varchar(320);
	DECLARE web_address varchar(255);
    DECLARE result boolean;
BEGIN
	SELECT email_address INTO user_email_address FROM users where id = $1;
    SELECT SUBSTRING(user_email_address,POSITION('@' in user_email_address) + 1) = $2 INTO result;
	IF result = false THEN
		raise 'E-mail and web address must have the same domain name.';
	END IF;
	RETURN result;
END; $_$;
 K   DROP FUNCTION public.validate_email_by_domain(integer, character varying);
       public          postgres    false            �            1259    58151 
   candidates    TABLE     �   CREATE TABLE public.candidates (
    id integer NOT NULL,
    first_name character varying(35) NOT NULL,
    last_name character varying(35) NOT NULL,
    identification_number character varying(11) NOT NULL,
    birth_date date NOT NULL
);
    DROP TABLE public.candidates;
       public         heap    postgres    false            �            1259    58241    employee_confirms    TABLE     �   CREATE TABLE public.employee_confirms (
    id integer NOT NULL,
    employee_id integer NOT NULL,
    is_confirmed boolean DEFAULT false NOT NULL
);
 %   DROP TABLE public.employee_confirms;
       public         heap    postgres    false            �            1259    58252    employee_confirms_employers    TABLE     o   CREATE TABLE public.employee_confirms_employers (
    id integer NOT NULL,
    employer_id integer NOT NULL
);
 /   DROP TABLE public.employee_confirms_employers;
       public         heap    postgres    false            �            1259    58239    employee_confirms_id_seq    SEQUENCE     �   ALTER TABLE public.employee_confirms ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.employee_confirms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            �            1259    58189 	   employees    TABLE     �   CREATE TABLE public.employees (
    id integer NOT NULL,
    first_name character varying(35) NOT NULL,
    last_name character varying(35) NOT NULL
);
    DROP TABLE public.employees;
       public         heap    postgres    false            �            1259    58179    employer_phones    TABLE     �   CREATE TABLE public.employer_phones (
    id integer NOT NULL,
    employer_id integer NOT NULL,
    phone_number character varying(12) NOT NULL
);
 #   DROP TABLE public.employer_phones;
       public         heap    postgres    false            �            1259    58177    employer_phones_id_seq    SEQUENCE     �   ALTER TABLE public.employer_phones ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.employer_phones_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �            1259    58163 	   employers    TABLE       CREATE TABLE public.employers (
    id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    web_address character varying(255) NOT NULL,
    CONSTRAINT chk_employers_web_address CHECK (public.validate_email_by_domain(id, web_address))
);
    DROP TABLE public.employers;
       public         heap    postgres    false    217            �            1259    58276    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    58269 
   job_titles    TABLE     g   CREATE TABLE public.job_titles (
    id integer NOT NULL,
    title character varying(255) NOT NULL
);
    DROP TABLE public.job_titles;
       public         heap    postgres    false            �            1259    58267    job_titles_id_seq    SEQUENCE     �   ALTER TABLE public.job_titles ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.job_titles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    58144    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    email_address character varying(320) NOT NULL,
    password character varying(25) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    58142    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �            1259    58201    verification_codes    TABLE     �   CREATE TABLE public.verification_codes (
    id integer NOT NULL,
    code character varying(38) NOT NULL,
    is_verified boolean DEFAULT false NOT NULL
);
 &   DROP TABLE public.verification_codes;
       public         heap    postgres    false            �            1259    58209    verification_codes_candidates    TABLE     r   CREATE TABLE public.verification_codes_candidates (
    id integer NOT NULL,
    candidate_id integer NOT NULL
);
 1   DROP TABLE public.verification_codes_candidates;
       public         heap    postgres    false            �            1259    58224    verification_codes_employers    TABLE     p   CREATE TABLE public.verification_codes_employers (
    id integer NOT NULL,
    employer_id integer NOT NULL
);
 0   DROP TABLE public.verification_codes_employers;
       public         heap    postgres    false            �            1259    58199    verification_codes_id_seq    SEQUENCE     �   ALTER TABLE public.verification_codes ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.verification_codes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    208                      0    58151 
   candidates 
   TABLE DATA           b   COPY public.candidates (id, first_name, last_name, identification_number, birth_date) FROM stdin;
    public          postgres    false    202   �T                 0    58241    employee_confirms 
   TABLE DATA           J   COPY public.employee_confirms (id, employee_id, is_confirmed) FROM stdin;
    public          postgres    false    212   �T                 0    58252    employee_confirms_employers 
   TABLE DATA           F   COPY public.employee_confirms_employers (id, employer_id) FROM stdin;
    public          postgres    false    213   U       
          0    58189 	   employees 
   TABLE DATA           >   COPY public.employees (id, first_name, last_name) FROM stdin;
    public          postgres    false    206   .U       	          0    58179    employer_phones 
   TABLE DATA           H   COPY public.employer_phones (id, employer_id, phone_number) FROM stdin;
    public          postgres    false    205   KU                 0    58163 	   employers 
   TABLE DATA           B   COPY public.employers (id, company_name, web_address) FROM stdin;
    public          postgres    false    203   �U                 0    58269 
   job_titles 
   TABLE DATA           /   COPY public.job_titles (id, title) FROM stdin;
    public          postgres    false    215   �U                 0    58144    users 
   TABLE DATA           <   COPY public.users (id, email_address, password) FROM stdin;
    public          postgres    false    201   	V                 0    58201    verification_codes 
   TABLE DATA           C   COPY public.verification_codes (id, code, is_verified) FROM stdin;
    public          postgres    false    208   ^V                 0    58209    verification_codes_candidates 
   TABLE DATA           I   COPY public.verification_codes_candidates (id, candidate_id) FROM stdin;
    public          postgres    false    209   {V                 0    58224    verification_codes_employers 
   TABLE DATA           G   COPY public.verification_codes_employers (id, employer_id) FROM stdin;
    public          postgres    false    210   �V                  0    0    employee_confirms_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.employee_confirms_id_seq', 1, false);
          public          postgres    false    211                       0    0    employer_phones_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.employer_phones_id_seq', 3, true);
          public          postgres    false    204                       0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    216                       0    0    job_titles_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.job_titles_id_seq', 6, true);
          public          postgres    false    214                       0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 6, true);
          public          postgres    false    200                        0    0    verification_codes_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.verification_codes_id_seq', 1, false);
          public          postgres    false    207            ^           2606    58155    candidates pk_candidates 
   CONSTRAINT     V   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT pk_candidates PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.candidates DROP CONSTRAINT pk_candidates;
       public            postgres    false    202            p           2606    58246 &   employee_confirms pk_employee_confirms 
   CONSTRAINT     d   ALTER TABLE ONLY public.employee_confirms
    ADD CONSTRAINT pk_employee_confirms PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.employee_confirms DROP CONSTRAINT pk_employee_confirms;
       public            postgres    false    212            r           2606    58256 :   employee_confirms_employers pk_employee_confirms_employers 
   CONSTRAINT     x   ALTER TABLE ONLY public.employee_confirms_employers
    ADD CONSTRAINT pk_employee_confirms_employers PRIMARY KEY (id);
 d   ALTER TABLE ONLY public.employee_confirms_employers DROP CONSTRAINT pk_employee_confirms_employers;
       public            postgres    false    213            f           2606    58193    employees pk_employees 
   CONSTRAINT     T   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT pk_employees PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.employees DROP CONSTRAINT pk_employees;
       public            postgres    false    206            d           2606    58183 "   employer_phones pk_employer_phones 
   CONSTRAINT     `   ALTER TABLE ONLY public.employer_phones
    ADD CONSTRAINT pk_employer_phones PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.employer_phones DROP CONSTRAINT pk_employer_phones;
       public            postgres    false    205            b           2606    58171    employers pk_employers 
   CONSTRAINT     T   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT pk_employers PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.employers DROP CONSTRAINT pk_employers;
       public            postgres    false    203            t           2606    58273    job_titles pk_job_titles 
   CONSTRAINT     V   ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT pk_job_titles PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.job_titles DROP CONSTRAINT pk_job_titles;
       public            postgres    false    215            Z           2606    58148    users pk_users 
   CONSTRAINT     L   ALTER TABLE ONLY public.users
    ADD CONSTRAINT pk_users PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.users DROP CONSTRAINT pk_users;
       public            postgres    false    201            h           2606    58206 (   verification_codes pk_verification_codes 
   CONSTRAINT     f   ALTER TABLE ONLY public.verification_codes
    ADD CONSTRAINT pk_verification_codes PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.verification_codes DROP CONSTRAINT pk_verification_codes;
       public            postgres    false    208            l           2606    58213 >   verification_codes_candidates pk_verification_codes_candidates 
   CONSTRAINT     |   ALTER TABLE ONLY public.verification_codes_candidates
    ADD CONSTRAINT pk_verification_codes_candidates PRIMARY KEY (id);
 h   ALTER TABLE ONLY public.verification_codes_candidates DROP CONSTRAINT pk_verification_codes_candidates;
       public            postgres    false    209            n           2606    58228 <   verification_codes_employers pk_verification_codes_employers 
   CONSTRAINT     z   ALTER TABLE ONLY public.verification_codes_employers
    ADD CONSTRAINT pk_verification_codes_employers PRIMARY KEY (id);
 f   ALTER TABLE ONLY public.verification_codes_employers DROP CONSTRAINT pk_verification_codes_employers;
       public            postgres    false    210            `           2606    58157 .   candidates uc_candidates_identification_number 
   CONSTRAINT     z   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT uc_candidates_identification_number UNIQUE (identification_number);
 X   ALTER TABLE ONLY public.candidates DROP CONSTRAINT uc_candidates_identification_number;
       public            postgres    false    202            v           2606    58275    job_titles uc_job_titles_title 
   CONSTRAINT     Z   ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT uc_job_titles_title UNIQUE (title);
 H   ALTER TABLE ONLY public.job_titles DROP CONSTRAINT uc_job_titles_title;
       public            postgres    false    215            \           2606    58150    users uc_users_email_address 
   CONSTRAINT     `   ALTER TABLE ONLY public.users
    ADD CONSTRAINT uc_users_email_address UNIQUE (email_address);
 F   ALTER TABLE ONLY public.users DROP CONSTRAINT uc_users_email_address;
       public            postgres    false    201            j           2606    58208 4   verification_codes uc_verification_codes_is_verified 
   CONSTRAINT     o   ALTER TABLE ONLY public.verification_codes
    ADD CONSTRAINT uc_verification_codes_is_verified UNIQUE (code);
 ^   ALTER TABLE ONLY public.verification_codes DROP CONSTRAINT uc_verification_codes_is_verified;
       public            postgres    false    208            w           2606    58158    candidates fk_candidates_users    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fk_candidates_users FOREIGN KEY (id) REFERENCES public.users(id) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT fk_candidates_users;
       public          postgres    false    202    2906    201                       2606    58247 0   employee_confirms fk_employee_confirms_employees    FK CONSTRAINT     �   ALTER TABLE ONLY public.employee_confirms
    ADD CONSTRAINT fk_employee_confirms_employees FOREIGN KEY (employee_id) REFERENCES public.employees(id) ON DELETE CASCADE;
 Z   ALTER TABLE ONLY public.employee_confirms DROP CONSTRAINT fk_employee_confirms_employees;
       public          postgres    false    2918    206    212            �           2606    58257 L   employee_confirms_employers fk_employee_confirms_employers_employee_confirms    FK CONSTRAINT     �   ALTER TABLE ONLY public.employee_confirms_employers
    ADD CONSTRAINT fk_employee_confirms_employers_employee_confirms FOREIGN KEY (id) REFERENCES public.employee_confirms(id) ON DELETE CASCADE;
 v   ALTER TABLE ONLY public.employee_confirms_employers DROP CONSTRAINT fk_employee_confirms_employers_employee_confirms;
       public          postgres    false    213    2928    212            �           2606    58262 D   employee_confirms_employers fk_employee_confirms_employers_employers    FK CONSTRAINT     �   ALTER TABLE ONLY public.employee_confirms_employers
    ADD CONSTRAINT fk_employee_confirms_employers_employers FOREIGN KEY (employer_id) REFERENCES public.employers(id) ON DELETE CASCADE;
 n   ALTER TABLE ONLY public.employee_confirms_employers DROP CONSTRAINT fk_employee_confirms_employers_employers;
       public          postgres    false    203    213    2914            z           2606    58194    employees fk_employees_users    FK CONSTRAINT     �   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fk_employees_users FOREIGN KEY (id) REFERENCES public.users(id) ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.employees DROP CONSTRAINT fk_employees_users;
       public          postgres    false    201    2906    206            y           2606    58184 .   employer_phones fk_employer_phones_employer_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.employer_phones
    ADD CONSTRAINT fk_employer_phones_employer_id FOREIGN KEY (employer_id) REFERENCES public.employers(id) ON DELETE CASCADE;
 X   ALTER TABLE ONLY public.employer_phones DROP CONSTRAINT fk_employer_phones_employer_id;
       public          postgres    false    2914    205    203            x           2606    58172    employers fk_employers_users    FK CONSTRAINT     �   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT fk_employers_users FOREIGN KEY (id) REFERENCES public.users(id) ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.employers DROP CONSTRAINT fk_employers_users;
       public          postgres    false    2906    203    201            |           2606    58219 I   verification_codes_candidates fk_verification_codes_candidates_candidates    FK CONSTRAINT     �   ALTER TABLE ONLY public.verification_codes_candidates
    ADD CONSTRAINT fk_verification_codes_candidates_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates(id) ON DELETE CASCADE;
 s   ALTER TABLE ONLY public.verification_codes_candidates DROP CONSTRAINT fk_verification_codes_candidates_candidates;
       public          postgres    false    202    209    2910            {           2606    58214 Q   verification_codes_candidates fk_verification_codes_candidates_verification_codes    FK CONSTRAINT     �   ALTER TABLE ONLY public.verification_codes_candidates
    ADD CONSTRAINT fk_verification_codes_candidates_verification_codes FOREIGN KEY (id) REFERENCES public.verification_codes(id) ON DELETE CASCADE;
 {   ALTER TABLE ONLY public.verification_codes_candidates DROP CONSTRAINT fk_verification_codes_candidates_verification_codes;
       public          postgres    false    2920    209    208            ~           2606    58234 F   verification_codes_employers fk_verification_codes_employers_employers    FK CONSTRAINT     �   ALTER TABLE ONLY public.verification_codes_employers
    ADD CONSTRAINT fk_verification_codes_employers_employers FOREIGN KEY (employer_id) REFERENCES public.employers(id) ON DELETE CASCADE;
 p   ALTER TABLE ONLY public.verification_codes_employers DROP CONSTRAINT fk_verification_codes_employers_employers;
       public          postgres    false    2914    210    203            }           2606    58229 O   verification_codes_employers fk_verification_codes_employers_verification_codes    FK CONSTRAINT     �   ALTER TABLE ONLY public.verification_codes_employers
    ADD CONSTRAINT fk_verification_codes_employers_verification_codes FOREIGN KEY (id) REFERENCES public.verification_codes(id) ON DELETE CASCADE;
 y   ALTER TABLE ONLY public.verification_codes_employers DROP CONSTRAINT fk_verification_codes_employers_verification_codes;
       public          postgres    false    2920    210    208               (   x�3��+-JN��t�..�4D N#C]c ����� �	            x������ � �            x������ � �      
      x������ � �      	   %   x�3�4�050555226�2B�p#sM�b���� ��J         :   x�3��+-JN�S�L�:�1���\G����8+S�Rs*�2s2s���s�J��b���� �<:         /   x�3��O+)O,JUpI-K��/H-�2C:%gd��&�p��qqq �M         E   x�3��+-JN��K�..MsH�M���K���442615�2�ʃ�*S�Rs*�2s2sA��J�`�b���� ��X            x������ � �            x������ � �            x������ � �     