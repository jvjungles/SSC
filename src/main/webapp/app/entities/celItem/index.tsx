import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import CelItem from './celItem';
import CelItemDetail from './celItem-detail';
import CelItemUpdate from './celItem-update';
import CelItemDeleteDialog from './celItem-delete-dialog';

const CelItemRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<CelItem />} />
    <Route path="new" element={<CelItemUpdate />} />
    <Route path=":id">
      <Route index element={<CelItemDetail />} />
      <Route path="edit" element={<CelItemUpdate />} />
      <Route path="delete" element={<CelItemDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default CelItemRoutes;
