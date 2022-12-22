import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ICelItem } from 'app/shared/model/celItem.model';
import { getEntity, updateEntity, createEntity, reset } from './celItem.reducer';

export const CelItemUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const celItemEntity = useAppSelector(state => state.celItem.entity);
  const loading = useAppSelector(state => state.celItem.loading);
  const updating = useAppSelector(state => state.celItem.updating);
  const updateSuccess = useAppSelector(state => state.celItem.updateSuccess);

  const handleClose = () => {
    navigate('/celItem');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...celItemEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          ...celItemEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="gitPodReactSpringJpaApp.celItem.home.createOrEditLabel" data-cy="CelItemCreateUpdateHeading">
            <Translate contentKey="gitPodReactSpringJpaApp.celItem.home.createOrEditLabel">Create or edit a CelItem</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="celItem-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('gitPodReactSpringJpaApp.celItem.celItemName')}
                id="celItem-celItemName"
                name="celItemName"
                data-cy="celItemName"
                type="text"
              />
              <ValidatedField
                label={translate('gitPodReactSpringJpaApp.celItem.celItemDescription')}
                id="celItem-celItemDescription"
                name="celItemDescription"
                data-cy="celItemDescription"
                type="text"
              />
              <ValidatedField
                label={translate('gitPodReactSpringJpaApp.celItem.celItemValor')}
                id="celItem-celItemValor"
                name="celItemValor"
                data-cy="celItemValor"
                type="text"
              />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/celItem" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default CelItemUpdate;
